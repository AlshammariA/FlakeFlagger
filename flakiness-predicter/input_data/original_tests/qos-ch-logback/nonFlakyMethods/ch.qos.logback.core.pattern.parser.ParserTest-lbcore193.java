@Test public void lbcore193() throws Exception {
  try {
    Parser p=new Parser("hello%(abc");
    p.setContext(context);
    Node t=p.parse();
    fail("where the is exception?");
  }
 catch (  ScanException ise) {
    assertEquals("Expecting RIGHT_PARENTHESIS token but got null",ise.getMessage());
  }
  StatusChecker sc=new StatusChecker(context);
  sc.assertContainsMatch("Expecting RIGHT_PARENTHESIS");
  sc.assertContainsMatch("See also " + Parser.MISSING_RIGHT_PARENTHESIS);
}
