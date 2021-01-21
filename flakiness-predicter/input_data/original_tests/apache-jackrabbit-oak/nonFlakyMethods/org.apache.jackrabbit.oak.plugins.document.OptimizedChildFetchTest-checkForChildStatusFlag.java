@Test public void checkForChildStatusFlag(){
  String head=mk.getHeadRevision();
  mk.commit("","+\"/root\":{}\n" + "+\"/root/a\":{}\n" + "+\"/root/a/b\":{}\n",head,"");
  assertTrue(hasChildren("/root"));
  assertTrue(hasChildren("/root/a"));
  assertFalse(hasChildren("/root/a/b"));
}
