"""
Campus Service Queue Manager (simple comments version)
Run the menu:  python queue_manager_commented.py
Run the demo:  python queue_manager_commented.py --demo
"""
# ^ Text inside triple quotes at the top of a file is a "docstring": a description of the file.

import sys  # "import" loads a built-in module. sys lets us read command-line words like --demo.

# ----------------------------------------------------------------------
# Constants and state
# ----------------------------------------------------------------------
# A line starting with # is a comment. Python ignores it.

VALID_PURPOSES = ("Enrollment", "Records", "Payment")  # tuple: a fixed list that cannot be changed
VALID_TYPES = ("regular", "priority")                  # the only allowed service types
NUM_COUNTERS = 2          # ALL_CAPS name = a constant (a value we never change)
PRIORITY_LIMIT = 2        # after 2 priority tickets in a row, a regular ticket gets a turn

all_tickets = []   # [] = empty list. Holds every ticket ever issued, oldest first
history = []       # completed tickets
counters = []      # one slot per counter: ticket number if busy, None if free
state = {"next_number": 1, "priority_streak": 0}  # {} = dictionary of name: value pairs


class QueueError(Exception):   # "class" makes a new type. (Exception) means it is an error type
    """Raised when an action is invalid; its message is safe to show the user."""


def reset_state():     # "def" defines a function. This one has no parameters.
    """Empty everything and set up the counters."""
    all_tickets.clear()      # .clear() removes every item from a list
    history.clear()
    counters.clear()
    counters.extend(None for _ in range(NUM_COUNTERS))
    # range(2) gives 0, 1. "for _ in" repeats once per number (_ means "I don't need the value").
    # None = "nothing", so each counter starts free. .extend() adds many items to a list.
    state["next_number"] = 1         # dictionary_name["key"] = value sets a value
    state["priority_streak"] = 0


# ----------------------------------------------------------------------
# Validation helpers
# ----------------------------------------------------------------------
def normalize_purpose(purpose):
    """Return a clean purpose like 'Records', or raise QueueError."""
    cleaned = str(purpose).strip().title()
    # str() turns the value into text; .strip() removes spaces at both ends;
    # .title() makes "records" into "Records" (first letter capital)
    if cleaned not in VALID_PURPOSES:    # "not in" checks the value is missing from the tuple
        raise QueueError(f"Invalid purpose '{purpose}'. Choose from: "
                         f"{', '.join(VALID_PURPOSES)}.")
        # raise = stop and report an error.
        # f"...{x}..." is an f-string: it puts the value of x inside the text.
        # ', '.join(list) glues the items together with ", " between them.
    return cleaned    # "return" sends a value back to whoever called the function


def normalize_type(service_type):
    """Return 'regular' or 'priority', or raise QueueError."""
    cleaned = str(service_type).strip().lower()   # .lower() makes all letters small
    if cleaned not in VALID_TYPES:
        raise QueueError(f"Invalid service type '{service_type}'. Choose from: "
                         f"{', '.join(VALID_TYPES)}.")
    return cleaned


def parse_ticket_number(text):
    """Turn typed text into an int, or raise QueueError."""
    try:                                  # try: run this code, and watch for errors
        return int(str(text).strip())     # int() converts text like "5" to the number 5
    except ValueError:                    # except: runs only if int() failed (e.g. "abc")
        raise QueueError(f"'{text}' is not a valid ticket number. Use digits only.")


def find_ticket(number):
    """Return the ticket with this number, or None if it does not exist."""
    for ticket in all_tickets:            # for loop: take each ticket in the list, one at a time
        if ticket["number"] == number:    # == compares two values (a single = would assign)
            return ticket
    return None                           # reached only if the loop found nothing


# ----------------------------------------------------------------------
# Required functions
# ----------------------------------------------------------------------
def issue_ticket(purpose, service_type="regular"):
    # service_type="regular" is a DEFAULT PARAMETER: if the caller skips it, "regular" is used
    """Validate inputs, create a ticket, and return its number."""
    purpose = normalize_purpose(purpose)          # validate first, so a bad request
    service_type = normalize_type(service_type)   # never uses up a ticket number
    number = state["next_number"]                 # read the next free number
    state["next_number"] += 1                     # += 1 means "add 1 to it"
    all_tickets.append({                          # .append() adds one item to the end of a list
        "number": number,
        "service_type": service_type,
        "purpose": purpose,
        "status": "waiting",     # every new ticket starts as waiting
        "counter": None,         # no counter assigned yet
    })
    return number


def issue_many(*requests):
    # *requests is *args: it collects any number of positional arguments into one tuple
    """Issue many tickets at once. All succeed or none are created."""
    cleaned = []      # valid requests collected here
    problems = []     # error messages collected here
    for position, request in enumerate(requests, start=1):
        # enumerate() gives a counter AND the item: (1, first), (2, second), ...
        try:
            if not isinstance(request, (tuple, list)) or len(request) not in (1, 2):
                # isinstance() checks the type; len() counts items; "or" is true if either part is
                raise QueueError("a request must be (purpose, service_type)")
            purpose = normalize_purpose(request[0])    # request[0] = first item (counting starts at 0)
            service_type = normalize_type(request[1]) if len(request) == 2 else "regular"
            # "A if condition else B" = one-line if/else: use A when true, otherwise B
            cleaned.append((purpose, service_type))
        except QueueError as err:                      # "as err" stores the error to use its message
            problems.append(f"request {position}: {err}")
    if problems:                                       # an empty list counts as False, a full one as True
        raise QueueError("No tickets issued. " + " | ".join(problems))   # + joins text together
    return [issue_ticket(p, t) for p, t in cleaned]
    # [ ... for ... in ... ] is a list comprehension: builds a new list in one line.
    # "for p, t in cleaned" unpacks each (purpose, type) pair into p and t.


def next_ticket(waiting, priority_streak):
    """Choose who is next. Returns an INDEX into `waiting`, or None if nobody is waiting."""
    first_priority = None     # index of the oldest priority ticket (None = not found yet)
    first_regular = None      # index of the oldest regular ticket
    for index, ticket in enumerate(waiting):    # enumerate gives the position and the ticket
        if ticket["service_type"] == "priority" and first_priority is None:
            first_priority = index              # "is None" checks that nothing was stored yet
        elif ticket["service_type"] == "regular" and first_regular is None:
            first_regular = index               # elif = "otherwise, if ..."
        if first_priority is not None and first_regular is not None:
            break                               # break stops the loop early: we found both

    if first_priority is None:
        return first_regular             # no priority waiting (may be None if queue is empty)
    if first_regular is None:
        return first_priority            # only priority waiting
    if priority_streak >= PRIORITY_LIMIT:    # >= means "greater than or equal to"
        return first_regular             # fairness: regular gets a turn after 2 priority
    return first_priority


def report(**kwargs):
    # **kwargs collects any extra keyword arguments (name=value) into a dictionary
    """Print the counts that were given. Unknown names are ignored."""
    labels = {"waiting": "Waiting", "served": "Served",
              "cancelled": "Cancelled", "free_counters": "Free counters"}
    print("--- Summary report ---")      # print() shows text on the screen
    shown = False                        # True/False flag to remember if we printed anything
    for key, label in labels.items():    # .items() gives each key and its value together
        if key in kwargs:                # "in" checks that the key exists in the dictionary
            print(f"{label}: {kwargs[key]}")
            shown = True
    if not shown:                        # "not" flips True/False
        print("(no counts supplied)")


# ----------------------------------------------------------------------
# Iterator
# ----------------------------------------------------------------------
class WaitingTicketIterator:
    """Goes through waiting tickets one by one (LIVE: it checks status each time)."""

    def __init__(self, tickets=None):
        # __init__ runs automatically when you create the object. "self" means "this object".
        self._tickets = all_tickets if tickets is None else tickets  # which list to walk
        self._pos = 0                # where we are in the list (names with _ are "private")
        self._finished = False       # becomes True after the tickets run out

    def __iter__(self):
        return self     # __iter__ makes the object usable in a for loop; it returns itself

    def __next__(self):
        # __next__ gives the next item each time next() or a for loop asks for one
        while not self._finished and self._pos < len(self._tickets):
            # while loop: keep repeating as long as the condition is True
            ticket = self._tickets[self._pos]
            self._pos += 1                    # move forward for the next call
            if ticket["status"] == "waiting": # skip served, serving and cancelled tickets
                return ticket
        self._finished = True                 # nothing left: remember that we are done
        raise StopIteration                   # StopIteration tells Python "no more items"


# ----------------------------------------------------------------------
# Queue operations (logic only: no input(), no print())
# ----------------------------------------------------------------------
def get_waiting():
    """List of waiting tickets, oldest first."""
    return [t for t in all_tickets if t["status"] == "waiting"]
    # list comprehension with a filter: keep only tickets where the "if" part is True


def free_counter_indexes():
    """Positions of counters that are free."""
    return [i for i in range(len(counters)) if counters[i] is None]


def update_streak(streak, ticket):
    """Return the new priority streak after serving `ticket`."""
    return streak + 1 if ticket["service_type"] == "priority" else 0
    # priority: add 1 to the streak; regular: reset to 0


def call_next():
    """Give the next eligible ticket to a free counter. Returns (ticket, counter_number)."""
    free = free_counter_indexes()
    if not free:                          # an empty list means no free counter
        raise QueueError("Both counters are busy. Complete a service first.")
    waiting = get_waiting()
    index = next_ticket(waiting, state["priority_streak"])
    if index is None:
        raise QueueError("No tickets are waiting.")
    ticket = waiting[index]               # waiting[index] picks the item at that position
    counter_index = free[0]               # use the first free counter
    ticket["status"] = "serving"          # changing the dictionary changes the real ticket
    ticket["counter"] = counter_index + 1 # counters are shown as 1 and 2, but stored as 0 and 1
    counters[counter_index] = ticket["number"]    # mark the counter busy
    state["priority_streak"] = update_streak(state["priority_streak"], ticket)
    return ticket, counter_index + 1      # returning two values gives a tuple


def complete_service(number):
    """Finish a ticket that is being served. Frees its counter and saves it to history."""
    ticket = find_ticket(number)
    if ticket is None:
        raise QueueError(f"Ticket {number} does not exist.")
    if ticket["status"] == "served":
        raise QueueError(f"Ticket {number} was already completed.")
    if ticket["status"] == "cancelled":
        raise QueueError(f"Ticket {number} was cancelled, so it cannot be completed.")
    if ticket["status"] == "waiting":
        raise QueueError(f"Ticket {number} is still waiting; it has not been called yet.")
    counters[ticket["counter"] - 1] = None   # free the counter again
    ticket["status"] = "served"
    history.append(ticket)                   # add to the completed history
    return ticket


def cancel_ticket(number):
    """Cancel a ticket, but only if it is still waiting."""
    ticket = find_ticket(number)
    if ticket is None:
        raise QueueError(f"Ticket {number} does not exist.")
    if ticket["status"] != "waiting":        # != means "not equal to"
        raise QueueError(f"Ticket {number} is '{ticket['status']}', so it cannot be cancelled "
                         f"(only waiting tickets can).")
    ticket["status"] = "cancelled"
    return ticket


def count_status(status):
    """How many tickets have this status."""
    return sum(1 for t in all_tickets if t["status"] == status)
    # sum() adds up numbers; here it adds 1 for every matching ticket (that is, it counts them)


# ----------------------------------------------------------------------
# Independent logic challenge: estimated waiting position
# ----------------------------------------------------------------------
def estimated_position(number):
    """Estimate when a ticket will be called (1 = next). Works on COPIES only."""
    simulated = [dict(t) for t in get_waiting()]   # dict(t) makes a copy of each ticket
    streak = state["priority_streak"]              # numbers are copied by value, so the real one is safe
    position = 0
    while simulated:                               # loop while the list still has tickets
        index = next_ticket(simulated, streak)     # same fairness rule as the real queue
        chosen = simulated.pop(index)              # .pop(i) removes and returns item number i
        position += 1
        if chosen["number"] == number:
            return position                        # found our ticket
        streak = update_streak(streak, chosen)
    return None                                    # ticket was not in the waiting list


# ----------------------------------------------------------------------
# Display helpers (these only print)
# ----------------------------------------------------------------------
def describe(ticket):
    """One-line text for a ticket."""
    return (f"#{ticket['number']:<3} {ticket['service_type']:<8} "
            f"{ticket['purpose']:<10} [{ticket['status']}]")
    # {value:<3} pads the text with spaces on the right to make columns line up


def show_waiting():
    waiting = get_waiting()
    if not waiting:
        print("No tickets are waiting.")
        return                                 # return alone just leaves the function early
    print("--- Waiting tickets (creation order) ---")
    for position in range(len(waiting)):       # range(n) gives 0, 1, ..., n-1 for numbering
        t = waiting[position]
        est = estimated_position(t["number"])
        print(f"{position + 1}. {describe(t)}  est. call position: {est}")
    busy = NUM_COUNTERS - len(free_counter_indexes())
    print(f"(Counters busy: {busy}/{NUM_COUNTERS}. Position counts calls, not minutes; "
          f"a call needs a free counter.)")


def show_counters_and_history():
    print("--- Counter status ---")
    for i in range(len(counters)):
        if counters[i] is None:
            print(f"Counter {i + 1}: FREE")
        else:
            print(f"Counter {i + 1}: BUSY with ticket #{counters[i]}")
    print("--- Completed history ---")
    if not history:
        print("(none yet)")
    for t in history:
        print(describe(t) + f"  counter {t['counter']}")


def show_report():
    report(waiting=count_status("waiting"),        # these name=value pairs end up inside **kwargs
           served=count_status("served"),
           cancelled=count_status("cancelled"),
           free_counters=len(free_counter_indexes()),
           note="metadata is ignored")             # unknown name: report() simply ignores it
    print(f"Currently being served: {count_status('serving')}")
    print(f"Tickets issued in total: {len(all_tickets)}")


# ----------------------------------------------------------------------
# Menu (input handling only)
# ----------------------------------------------------------------------
MENU = """
===== Campus Service Queue Manager =====
1 Issue a ticket
2 Call the next ticket
3 Complete a service
4 Cancel a waiting ticket
5 Show waiting tickets
6 Show counter status and completed history
7 Show a summary report
8 Exit"""
# Triple quotes let a string span many lines.


def menu_issue():
    purpose = input(f"Purpose ({'/'.join(VALID_PURPOSES)}): ")   # input() waits for the user to type
    service_type = input("Service type (regular/priority) [regular]: ").strip() or "regular"
    # "x or y" gives y when x is empty, so pressing Enter means "regular"
    number = issue_ticket(purpose, service_type)
    print(f"Ticket #{number} issued.")


def menu_call():
    ticket, counter = call_next()          # unpack the 2 returned values into 2 names
    print(f"Now serving: {describe(ticket)} at counter {counter}.")


def menu_complete():
    number = parse_ticket_number(input("Ticket number to complete: "))
    ticket = complete_service(number)
    print(f"Ticket #{ticket['number']} completed. Counter {ticket['counter']} is free.")


def menu_cancel():
    number = parse_ticket_number(input("Ticket number to cancel: "))
    cancel_ticket(number)
    print(f"Ticket #{number} cancelled.")


ACTIONS = {"1": menu_issue, "2": menu_call, "3": menu_complete, "4": menu_cancel,
           "5": show_waiting, "6": show_counters_and_history, "7": show_report}
# A dictionary that maps each menu choice to a function. Functions can be stored like any value.


def main():
    reset_state()
    while True:                            # loop forever until we hit "break"
        print(MENU)
        choice = input("Choose 1-8: ").strip()
        if choice == "8":
            print("Goodbye.")
            break                          # leave the loop, so the program ends
        action = ACTIONS.get(choice)       # .get() returns None instead of crashing if key is missing
        if action is None:
            print(f"'{choice}' is not a valid menu choice. Enter a number from 1 to 8.")
            continue                       # continue jumps back to the top of the loop
        try:
            action()                       # () runs the function we looked up
        except QueueError as err:          # catch our own errors and show them nicely
            print(f"Error: {err}")


# ----------------------------------------------------------------------
# Demonstration of every required scenario (python queue_manager_commented.py --demo)
# ----------------------------------------------------------------------
def demo():
    def show(title):                       # a function defined inside another function
        print(f"\n### {title}")            # \n prints a blank line first

    reset_state()

    show("1. Issue six tickets with issue_many (both service types)")
    nums = issue_many(("Enrollment", "regular"), ("Records", "priority"),
                      ("Payment", "priority"), ("Enrollment", "priority"),
                      ("Payment",), ("Records", "regular"))
    print("Issued:", nums)
    show_waiting()

    show("1b. Invalid request in issue_many creates NOTHING")
    before = len(all_tickets)
    try:
        issue_many(("Payment", "regular"), ("Parking", "priority"))
    except QueueError as err:
        print("Error:", err)
    print("Tickets before/after:", before, len(all_tickets))
    assert before == len(all_tickets)      # assert stops the program if this is False (a self-check)

    show("2. Call into both counters (priority 2 then 3)")
    for _ in range(2):                     # repeat 2 times
        print(describe(call_next()[0]))    # [0] takes the first value (the ticket) from the pair
    print("Third call while both busy:")
    try:
        call_next()
    except QueueError as err:
        print("Error:", err)

    show("3. Complete ticket 2 -> counter frees; fairness: regular #1 is next")
    complete_service(2)
    show_counters_and_history()
    t, c = call_next()
    print(f"Called {describe(t)} at counter {c}  (streak was 2, so regular goes)")
    assert t["number"] == 1

    show("3b. Cancel waiting ticket 5, confirm it is skipped")
    cancel_ticket(5)
    complete_service(3)
    t, c = call_next()
    print(f"Called {describe(t)}  (priority #4; #5 is cancelled)")
    assert t["number"] == 4
    complete_service(1)
    t, c = call_next()
    print(f"Called {describe(t)}  (cancelled #5 skipped, so #6)")
    assert t["number"] == 6

    show("4. Error handling")
    for attempt in (99, 2):                # loop over a tuple of values
        try:
            complete_service(attempt)
        except QueueError as err:
            print("Error:", err)
    try:
        parse_ticket_number("abc")
    except QueueError as err:
        print("Error:", err)

    show("5. Iterator to exhaustion, then StopIteration (live iterator)")
    complete_service(4)
    complete_service(6)
    new = issue_many(("Records", "regular"), ("Payment", "priority"))
    print("New tickets:", new)
    it = WaitingTicketIterator()           # creating an object from our class
    print("Created iterator while 2 tickets waiting.")
    cancel_ticket(new[0])
    print("Cancelled #%d AFTER creating iterator -> live iterator skips it." % new[0])
    # %d is an older way to insert a number into text
    for t in it:                           # a for loop calls __next__ until StopIteration
        print(" yielded", describe(t))
    try:
        next(it)                           # next() asks for one more item by hand
    except StopIteration:
        print("next() after exhaustion raised StopIteration (verified)")

    show("6. Estimated position does not change the live queue")
    reset_state()
    issue_many(("Records", "regular"), ("Payment", "priority"), ("Records", "priority"),
               ("Enrollment", "priority"), ("Payment", "regular"))
    snapshot = [dict(t) for t in all_tickets], state["priority_streak"]
    for n in range(1, 6):                  # range(1, 6) gives 1, 2, 3, 4, 5
        print(f"Ticket {n}: estimated call position {estimated_position(n)}")
    assert snapshot == ([dict(t) for t in all_tickets], state["priority_streak"])
    print("Live queue unchanged: verified. Expected call order: 2, 3, 1, 4, 5")
    show_report()


if __name__ == "__main__":
    # __name__ is "__main__" only when you run this file directly (not when another file imports it)
    if "--demo" in sys.argv:               # sys.argv is the list of words typed on the command line
        demo()
    else:
        main()