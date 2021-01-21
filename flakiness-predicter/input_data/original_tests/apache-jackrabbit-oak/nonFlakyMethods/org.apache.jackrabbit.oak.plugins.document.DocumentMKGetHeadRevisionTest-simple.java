@Test public void simple() throws Exception {
  SimpleNodeScenario scenario=new SimpleNodeScenario(mk);
  String rev1=scenario.create();
  String rev2=mk.getHeadRevision();
  assertEquals(rev1,rev2);
  String rev3=scenario.deleteA();
  assertFalse(rev3.equals(rev2));
}
