@Test public void smoke() throws InterruptedException, IOException {
  Runner runner=new Runner(fa);
  Thread t=new Thread(runner);
  t.start();
  double delayCoefficient=2.0;
  for (int i=0; i < 5; i++) {
    Thread.sleep((int)(RecoveryCoordinator.BACKOFF_COEFFICIENT_MIN * delayCoefficient));
    closeLogFileOnPurpose();
  }
  runner.setDone(true);
  t.join();
  double bestCaseSuccessRatio=1 / delayCoefficient;
  double lossinessFactor=0.35;
  double resilianceFactor=(1 - lossinessFactor);
  ResilienceUtil.verify(logfileStr,"^hello (\\d{1,5})$",runner.getCounter(),bestCaseSuccessRatio * resilianceFactor);
}
