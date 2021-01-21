@Test public void addAndMove(){
  DocumentMK mk=createMK();
  String head=mk.getHeadRevision();
  head=mk.commit("","+\"/root\":{}\n" + "+\"/root/a\":{}\n" + "+\"/root/a/b\":{}\n",head,"");
  head=mk.commit("",">\"/root/a\":\"/root/c\"\n",head,"");
  assertFalse(mk.nodeExists("/root/a",head));
  assertTrue(mk.nodeExists("/root/c/b",head));
}
