/** 
 * 7.   >/a:/b >/c:/a        does not commute See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 231
 */
@Test public void test7(){
  MoveTracker mt3=new MoveTracker();
  mt3.addMove("/a","/b");
  mt3.addMove("/c","/a");
  assertEquals("/a",mt3.getSourcePath("/b"));
  assertEquals("/c",mt3.getSourcePath("/a"));
  assertEquals("/b",mt3.getDestPath("/a"));
  assertEquals("/a",mt3.getDestPath("/c"));
}
