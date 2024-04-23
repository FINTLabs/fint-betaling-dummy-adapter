# FINT Okonomi dummy adapter

An adapter used in play-with-fint to simulate an economic system. The adapter responds to requests to create invoice bases and changes to the invoices. Intended for testing purposes only.

| Siste tall | Status                               |
|------------|--------------------------------------|
| 0          | Vanlig faktura, ikke betalt          |
| 1          | Vanlig faktura, betalt               |
| 2          | Kreditnota                           |
| 3          | Ordre, men ikke fakturert            |
| 4          | Ordre, men ikke fakturert            |
| 5          | Ordre, men ikke fakturert            |
| 6          | Ordre, men ikke fakturert            |
| 7          | Feil i adapter                       |
| 8          | Avslått, valideringsfeil             |
| 9          | Simulert sendingsfeil (endre corrid) |
