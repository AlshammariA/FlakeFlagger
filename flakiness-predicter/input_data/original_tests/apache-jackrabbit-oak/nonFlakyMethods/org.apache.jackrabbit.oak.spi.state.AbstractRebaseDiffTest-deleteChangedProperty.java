@Test public void deleteChangedProperty(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.setProperty("x",11);
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.removeProperty("x");
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void deleteChangedProperty(    NodeBuilder builder,    PropertyState before){
      assertEquals(createProperty("x",1),before);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
