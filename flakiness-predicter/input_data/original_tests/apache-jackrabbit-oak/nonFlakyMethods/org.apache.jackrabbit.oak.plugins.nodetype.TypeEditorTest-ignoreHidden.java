@Test public void ignoreHidden() throws CommitFailedException {
  EditorHook hook=new EditorHook(new TypeEditorProvider());
  NodeState root=INITIAL_CONTENT;
  NodeBuilder builder=root.builder();
  NodeState before=builder.getNodeState();
  builder.child(":hidden");
  NodeState after=builder.getNodeState();
  hook.processCommit(before,after,CommitInfo.EMPTY);
  before=after;
  builder.child(":hidden").setProperty("prop","value");
  after=builder.getNodeState();
  hook.processCommit(before,after,CommitInfo.EMPTY);
  before=after;
  builder.getChildNode(":hidden").remove();
  after=builder.getNodeState();
  hook.processCommit(before,after,CommitInfo.EMPTY);
}
