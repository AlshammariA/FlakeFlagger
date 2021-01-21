@Test public void changeChangedProperty(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.setProperty("x",11);
  headBuilder.setProperty("y",22);
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.setProperty("x",11);
  branchBuilder.setProperty("y",0);
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void changeChangedProperty(    NodeBuilder builder,    PropertyState before,    PropertyState after){
      assertEquals(createProperty("y",0),after);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
