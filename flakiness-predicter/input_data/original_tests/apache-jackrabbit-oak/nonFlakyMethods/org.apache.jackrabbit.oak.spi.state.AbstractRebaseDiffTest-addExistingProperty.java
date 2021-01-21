@Test public void addExistingProperty(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.setProperty("p",1);
  headBuilder.setProperty("p",1);
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.setProperty("p",1);
  branchBuilder.setProperty("p",0);
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void addExistingProperty(    NodeBuilder builder,    PropertyState before,    PropertyState after){
      assertEquals(createProperty("p",0),after);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
