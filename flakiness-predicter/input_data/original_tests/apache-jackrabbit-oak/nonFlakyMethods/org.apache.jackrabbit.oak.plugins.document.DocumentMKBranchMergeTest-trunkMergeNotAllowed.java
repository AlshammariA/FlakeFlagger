@Test public void trunkMergeNotAllowed(){
  String rev=mk.commit("","+\"/child1\":{}",null,"");
  try {
    mk.merge(rev,"");
    fail("Exception expected");
  }
 catch (  Exception expected) {
  }
}
