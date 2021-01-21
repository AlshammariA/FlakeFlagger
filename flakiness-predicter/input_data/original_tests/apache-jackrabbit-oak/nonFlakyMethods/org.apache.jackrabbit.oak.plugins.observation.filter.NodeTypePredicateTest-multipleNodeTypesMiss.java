@Test public void multipleNodeTypesMiss(){
  NodeState node=createNodeOfType(NT_FILE);
  TypePredicate p=new TypePredicate(node,new String[]{NT_FOLDER,NT_RESOURCE,JCR_CONTENT});
  assertFalse(p.apply(node));
}
