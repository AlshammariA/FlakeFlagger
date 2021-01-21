@Test public void changeDeletedProperty(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.removeProperty("x");
  headBuilder.removeProperty("y");
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.setProperty("x",1);
  branchBuilder.setProperty("y",0);
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void changeDeletedProperty(    NodeBuilder builder,    PropertyState after){
      assertEquals(createProperty("y",0),after);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
