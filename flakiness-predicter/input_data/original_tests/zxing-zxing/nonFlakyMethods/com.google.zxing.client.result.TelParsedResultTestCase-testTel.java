@Test public void testTel(){
  doTest("tel:+15551212","+15551212",null);
  doTest("tel:2125551212","2125551212",null);
}
