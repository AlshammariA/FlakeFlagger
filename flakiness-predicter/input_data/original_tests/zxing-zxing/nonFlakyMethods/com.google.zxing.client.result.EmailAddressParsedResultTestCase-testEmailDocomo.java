@Test public void testEmailDocomo(){
  doTest("MATMSG:TO:srowen@example.org;;","srowen@example.org",null,null);
  doTest("MATMSG:TO:srowen@example.org;SUB:Stuff;;","srowen@example.org","Stuff",null);
  doTest("MATMSG:TO:srowen@example.org;SUB:Stuff;BODY:This is some text;;","srowen@example.org","Stuff","This is some text");
}
