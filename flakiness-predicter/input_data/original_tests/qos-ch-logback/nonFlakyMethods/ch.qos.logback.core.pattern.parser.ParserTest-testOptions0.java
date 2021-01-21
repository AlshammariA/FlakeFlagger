@Test public void testOptions0() throws Exception {
  Parser p=new Parser("%45x{'test '}");
  Node t=p.parse();
  SimpleKeywordNode witness=new SimpleKeywordNode("x");
  witness.setFormatInfo(new FormatInfo(45,Integer.MAX_VALUE));
  List<String> ol=new ArrayList<String>();
  ol.add("test ");
  witness.setOptions(ol);
  assertEquals(witness,t);
}
