@Test public void testGetInstanceFromTree(){
  Tree privRoot=root.getTree(PRIVILEGES_PATH);
  try {
    Tree tmp=privRoot.addChild("tmpPrivilege");
    PrivilegeBits tmpBits=PrivilegeBits.getInstance(privRoot.getProperty(REP_NEXT));
    tmpBits.writeTo(tmp);
    Map<Tree,PrivilegeBits> treeToBits=new HashMap<Tree,PrivilegeBits>();
    treeToBits.put(privRoot.getChild(JCR_READ),PrivilegeBits.BUILT_IN.get(JCR_READ));
    treeToBits.put(tmp,tmpBits);
    treeToBits.put(privRoot,tmpBits);
    for (    Tree tree : treeToBits.keySet()) {
      assertEquals(treeToBits.get(tree),PrivilegeBits.getInstance(tree));
    }
  }
  finally {
    root.refresh();
  }
}
