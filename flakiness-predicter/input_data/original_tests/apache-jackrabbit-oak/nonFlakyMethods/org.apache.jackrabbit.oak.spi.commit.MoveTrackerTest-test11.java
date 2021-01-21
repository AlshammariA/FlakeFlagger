/** 
 * 11.  >/a:/b >/b:/c     =  >/a:/c See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 236
 */
@Test public void test11(){
  MoveTracker mt=new MoveTracker();
  mt.addMove("/a","/b");
  mt.addMove("/b","/c");
  assertEquals("/a",mt.getSourcePath("/c"));
  assertEquals("/c",mt.getDestPath("/a"));
}
