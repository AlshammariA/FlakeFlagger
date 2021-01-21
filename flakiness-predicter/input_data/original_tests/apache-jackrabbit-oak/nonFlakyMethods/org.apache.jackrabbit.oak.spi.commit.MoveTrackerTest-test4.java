/** 
 * 4.   >/a/b:/c >/a:/d   =  >/a:/d >/d/b:/c See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 225
 */
@Test public void test4(){
  MoveTracker mt1=new MoveTracker();
  mt1.addMove("/a/b","/c");
  mt1.addMove("/a","/d");
  assertEquals("/a/b",mt1.getSourcePath("/c"));
  assertEquals("/a",mt1.getSourcePath("/d"));
  assertEquals("/c",mt1.getDestPath("/a/b"));
  assertEquals("/d",mt1.getDestPath("/a"));
}
