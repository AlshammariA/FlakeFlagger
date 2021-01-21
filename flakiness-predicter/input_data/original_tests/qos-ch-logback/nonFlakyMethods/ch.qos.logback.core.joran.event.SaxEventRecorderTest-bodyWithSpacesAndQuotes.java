@Test public void bodyWithSpacesAndQuotes() throws Exception {
  List<SaxEvent> seList=doTest("spacesAndQuotes.xml");
  assertEquals(3,seList.size());
  BodyEvent be=(BodyEvent)seList.get(1);
  assertEquals("[x][x] \"xyz\"%n",be.getText());
}
