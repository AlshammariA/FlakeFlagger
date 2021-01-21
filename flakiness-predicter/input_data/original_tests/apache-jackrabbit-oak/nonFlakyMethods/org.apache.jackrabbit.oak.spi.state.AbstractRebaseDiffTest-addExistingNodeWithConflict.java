@Test public void addExistingNodeWithConflict(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.setChildNode("n");
  headBuilder.setChildNode("m").setChildNode("m1");
  headBuilder.getChildNode("m").setProperty("p",1);
  headBuilder.getChildNode("m").setChildNode("mm").setChildNode("mmm").setProperty("pp",1);
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.setChildNode("n");
  branchBuilder.setChildNode("m").setChildNode("m2");
  branchBuilder.getChildNode("m").setProperty("q",1);
  branchBuilder.getChildNode("m").setChildNode("mm").setChildNode("mmm").setProperty("pp",2);
  NodeState branch=branchBuilder.getNodeState();
  NodeBuilder builder=head.builder();
class ConflictResolver extends RebaseDiff {
    private final ConflictResolver parent;
    private ConflictResolver(    NodeBuilder builder){
      this(null,builder);
    }
    public ConflictResolver(    ConflictResolver parent,    NodeBuilder builder){
      super(builder);
      this.parent=parent;
    }
    @Override protected void resolve(){
      if (parent == null) {
        super.resolve();
      }
 else {
        parent.resolve();
      }
    }
    @Override protected AbstractRebaseDiff createDiff(    NodeBuilder builder,    String name){
      return new ConflictResolver(this,builder.getChildNode(name));
    }
    @Override protected void addExistingProperty(    NodeBuilder builder,    PropertyState before,    PropertyState after){
      assertEquals(createProperty("pp",1),before);
      assertEquals(createProperty("pp",2),after);
      resolve();
    }
  }
  RebaseDiff rebaseDiff=new ConflictResolver(builder);
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
