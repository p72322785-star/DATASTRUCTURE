class p5 {

   @SuppressWarnings("unused")
   static int tour(int[] petrol, int[] dist) {
    if (petrol.length != dist.length || petrol.length == 0)
        return -1;

    int start = 0, deficit = 0, balance = 0;

    for (int i = 0; i < petrol.length; i++) {
        balance += petrol[i] - dist[i];

        if (balance < 0) {
            start = i + 1;
            deficit += balance;
            balance = 0;
        }
    }

    return (balance + deficit >= 0) ? start : -1;
}
}