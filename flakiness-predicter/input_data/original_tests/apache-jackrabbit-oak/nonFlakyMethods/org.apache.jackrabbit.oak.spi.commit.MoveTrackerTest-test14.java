/** 
 * 14.  >/a:/b >/c:/b/d   =  >/c:/a/d >/a:/b See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 240
 */
@Test public void test14(){
  MoveTracker mt5=new MoveTracker();
  mt5.addMove("/a","/b");
  mt5.addMove("/c","/b/d");
  assertEquals("/a",mt5.getSourcePath("/b"));
  assertEquals("/c",mt5.getSourcePath("/b/d"));
  assertEquals("/b",mt5.getDestPath("/a"));
  assertEquals("/b/d",mt5.getDestPath("/c"));
}
