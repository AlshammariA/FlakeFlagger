@Test public void testEmailAddress(){
  doTest("srowen@example.org","srowen@example.org",null,null);
  doTest("mailto:srowen@example.org","srowen@example.org",null,null);
}
