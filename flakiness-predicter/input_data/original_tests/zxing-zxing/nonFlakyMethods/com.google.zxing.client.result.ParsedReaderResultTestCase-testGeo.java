@Test public void testGeo(){
  doTestResult("geo:1,2","1.0, 2.0",ParsedResultType.GEO);
  doTestResult("GEO:1,2","1.0, 2.0",ParsedResultType.GEO);
  doTestResult("geo:1,2,3","1.0, 2.0, 3.0m",ParsedResultType.GEO);
  doTestResult("geo:80.33,-32.3344,3.35","80.33, -32.3344, 3.35m",ParsedResultType.GEO);
  doTestResult("geo","geo",ParsedResultType.TEXT);
  doTestResult("geography","geography",ParsedResultType.TEXT);
}
