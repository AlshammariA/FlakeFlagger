@Test public void testGeo(){
  doTest("geo:1,2",1.0,2.0,0.0,null);
  doTest("geo:80.33,-32.3344,3.35",80.33,-32.3344,3.35,null);
  doTest("geo:-20.33,132.3344,0.01",-20.33,132.3344,0.01,null);
  doTest("geo:-20.33,132.3344,0.01?q=foobar",-20.33,132.3344,0.01,"q=foobar");
  doTest("GEO:-20.33,132.3344,0.01?q=foobar",-20.33,132.3344,0.01,"q=foobar");
}
