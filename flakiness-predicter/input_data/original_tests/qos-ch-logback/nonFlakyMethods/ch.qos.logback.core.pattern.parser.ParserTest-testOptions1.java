@Test public void testOptions1() throws Exception {
  Parser p=new Parser("%45x{a, b}");
  Node t=p.parse();
  SimpleKeywordNode witness=new SimpleKeywordNode("x");
  witness.setFormatInfo(new FormatInfo(45,Integer.MAX_VALUE));
  List<String> ol=new ArrayList<String>();
  ol.add("a");
  ol.add("b");
  witness.setOptions(ol);
  assertEquals(witness,t);
}
