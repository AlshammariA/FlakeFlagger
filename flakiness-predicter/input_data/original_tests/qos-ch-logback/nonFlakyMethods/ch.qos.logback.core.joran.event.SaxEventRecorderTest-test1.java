@Test public void test1() throws Exception {
  List<SaxEvent> seList=doTest("event1.xml");
  assertTrue(statusChecker.getHighestLevel(0) == Status.INFO);
  assertEquals(11,seList.size());
}
