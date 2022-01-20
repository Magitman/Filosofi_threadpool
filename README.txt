Si consideri il problema dei filosofi, descritto nel seguito.

Ci sono N filosofi, la cui attività ciclica è “pensare” seguita da “mangiare”. I filosofi ciclano all’infinito alternando lo stato “thinking” a quello “eating”, rimanendo un numero finito di secondi nello stato.

L’attività “pensare” non richiede l’uso di alcuna risorsa. Quindi un filosofo può entrare nello stato “thinking” liberamente, in modo indipendente da quello che fanno gli altri filosofi.

L’attività “mangiare” richiede invece di avere due forchette (“chopstick”), una per la mano sinistra e una per la mano destra. Ad ogni filosofo è assegnata una forchetta sinistra e una destra (in modo fisso – non possono prendere a caso quelle che sono sul tavolo).

Sul tavolo ci sono solo N “chopstick” quindi un filosofo che entra in stato “eating” deve competere con gli altri per avere le forchette (se almeno un suo vicino è in stato eating, detiene la forchetta che gli serve). Le forchette sono dunque risorse condivise tra i filosofi.

Supponendo di implementare ogni filosofo come thread concorrente, sviluppare un’applicazione che gestisca le transizioni di stato dei filosofi in modo corretto, prevenendo eventuali deadlock.

In particolare, si noti che se ad ogni filosofo si assegna la forchetta alla sua sinistra come “leftChopstick” e quella alla sua destra come “rightChopstick” e cerca di acquisire le forchette sempre in quest'ordine, si rischia il deadlock: potrebbe darsi che tutti i filosofi si impossessino della “leftChopstick” e non possano più prendere la “rightChopstick” – siccome sono tutti bloccati, nessuno rilascia la forchetta che detiene.

Per evitare questo problema, assegnare a N-1 filosofi la forchetta alla propria sinistra come “leftChopstick” e la forchetta alla propria destra come “rightChopstick”. All’ultimo filosofo assegnare le forchette al contrario.

NB: implementare il tutto (potete fare le prove con N=3) con sincronizzazione lato server (cioè sincronizzando i metodi delle chopstick). Poi implementare il tutto con sincronizzazione lato client (sincronizzando i metodi dei filosofi).