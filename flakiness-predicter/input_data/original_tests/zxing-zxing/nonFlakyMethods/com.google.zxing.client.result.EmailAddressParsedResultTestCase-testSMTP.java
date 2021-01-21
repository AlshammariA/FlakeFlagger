@Test public void testSMTP(){
  doTest("smtp:srowen@example.org","srowen@example.org",null,null);
  doTest("SMTP:srowen@example.org","srowen@example.org",null,null);
  doTest("smtp:srowen@example.org:foo","srowen@example.org","foo",null);
  doTest("smtp:srowen@example.org:foo:bar","srowen@example.org","foo","bar");
}
