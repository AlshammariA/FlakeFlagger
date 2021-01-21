/** 
 * 14.  >/a/b:/b >/a:/b/d    does not commute  (p > r) See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 241
 */
@Test public void test14a(){
  MoveTracker mt6=new MoveTracker();
  mt6.addMove("/a/b","/b");
  mt6.addMove("/a","/b/d");
  assertEquals("/a/b",mt6.getSourcePath("/b"));
  assertEquals("/a",mt6.getSourcePath("/b/d"));
  assertEquals("/b",mt6.getDestPath("/a/b"));
  assertEquals("/b/d",mt6.getDestPath("/a"));
}
