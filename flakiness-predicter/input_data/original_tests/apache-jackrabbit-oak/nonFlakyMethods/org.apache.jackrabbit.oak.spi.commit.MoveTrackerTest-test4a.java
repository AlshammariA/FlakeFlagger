/** 
 * 4.   >/a/b:/c >/a:/c/d    does not commute  (q < s) See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 226
 */
@Test public void test4a(){
  MoveTracker mt2=new MoveTracker();
  mt2.addMove("/a/b","/c");
  mt2.addMove("/a","/c/d");
  assertEquals("/a/b",mt2.getSourcePath("/c"));
  assertEquals("/a",mt2.getSourcePath("/c/d"));
  assertEquals("/c",mt2.getDestPath("/a/b"));
  assertEquals("/c/d",mt2.getDestPath("/a"));
}
