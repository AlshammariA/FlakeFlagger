/** 
 * 1.   >/a:/b >/c:/d     =  >/c:/d >/a:b See http://svn.apache.org/viewvc/jackrabbit/sandbox/jackrabbit-microkernel/src/main/java/org/apache/jackrabbit/state/ChangeLog.java?view=markup Line 222
 */
@Test public void test1(){
  MoveTracker mt=new MoveTracker();
  mt.addMove("/a","/b");
  mt.addMove("/c","/d");
  assertEquals("/a",mt.getSourcePath("/b"));
  assertEquals("/c",mt.getSourcePath("/d"));
  assertEquals("/b",mt.getDestPath("/a"));
  assertEquals("/d",mt.getDestPath("/c"));
}
