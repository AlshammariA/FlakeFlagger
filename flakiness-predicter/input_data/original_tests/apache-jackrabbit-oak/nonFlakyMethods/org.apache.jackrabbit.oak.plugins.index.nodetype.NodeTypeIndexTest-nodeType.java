@Test public void nodeType() throws Exception {
  NodeBuilder root=store.getRoot().builder();
  root.getChildNode("rep:security").remove();
  addFolder(root,"folder-1");
  addFolder(root,"folder-2");
  addFile(root,"file-1");
  store.merge(root,new EditorHook(new IndexUpdateProvider(new PropertyIndexEditorProvider())),CommitInfo.EMPTY);
  NodeState rootState=store.getRoot();
  NodeTypeIndex index=new NodeTypeIndex();
  FilterImpl filter;
  filter=createFilter(rootState,JcrConstants.NT_FOLDER);
  assertEquals(6.0,index.getCost(filter,rootState),0.0);
  checkCursor(index.query(filter,rootState),"/folder-1","/folder-2");
  filter=createFilter(rootState,JcrConstants.NT_FILE);
  assertEquals(5.0,index.getCost(filter,rootState),0.0);
  checkCursor(index.query(filter,rootState),"/file-1");
  filter=createFilter(rootState,JcrConstants.NT_HIERARCHYNODE);
  assertEquals(7.0,index.getCost(filter,rootState),0.0);
  checkCursor(index.query(filter,rootState),"/folder-1","/folder-2","/file-1");
}
