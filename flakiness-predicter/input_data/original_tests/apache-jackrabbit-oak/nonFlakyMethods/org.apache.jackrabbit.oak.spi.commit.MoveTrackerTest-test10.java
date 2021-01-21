/** 
 * 10.  >/a:/b >/b/c:/d   =  >/a/c:/d >/a:/b See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 234
 */
@Test public void test10(){
  MoveTracker mt=new MoveTracker();
  mt.addMove("/a","/b");
  mt.addMove("/b/c","/d");
  assertEquals("/a",mt.getSourcePath("/b"));
  assertEquals("/a/c",mt.getSourcePath("/d"));
  assertEquals("/b",mt.getDestPath("/a"));
  assertEquals("/d",mt.getDestPath("/a/c"));
}
