@Test public void persistedTimerTest() throws ExecutionException, InterruptedException {
  OrbitStage stage1=createStage();
  OrbitStage frontend=createClient();
  IReminderTestActor actor=frontend.getReference(IReminderTestActor.class,"1");
  actor.addReminder("bla",0,20,TimeUnit.MILLISECONDS).join();
  assertEquals("bla",remindersReceived.poll(5,TimeUnit.SECONDS));
  stage1.stop().join();
  remindersReceived.clear();
  assertNull(remindersReceived.poll(5,TimeUnit.MILLISECONDS));
  OrbitStage stage2=createStage();
  assertEquals("bla",remindersReceived.poll(5,TimeUnit.SECONDS));
}
