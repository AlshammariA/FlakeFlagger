@Test public void testTransformAndParse() throws ParseException {
  p.parse(new XPathToSQL2Converter().convert("/jcr:root/test/*/nt:resource[@jcr:encoding]"));
}
