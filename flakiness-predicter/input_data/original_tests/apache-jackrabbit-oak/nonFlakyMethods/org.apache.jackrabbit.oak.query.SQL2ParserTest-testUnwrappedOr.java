@Test public void testUnwrappedOr() throws ParseException {
  String q=new XPathToSQL2Converter().convert("/jcr:root/home//test/* [@type='t1' or @type='t2' or @type='t3']");
  String token="and (b.[type] = 't1' or b.[type] = 't2' or b.[type] = 't3')";
  assertTrue(q.contains(token));
}
