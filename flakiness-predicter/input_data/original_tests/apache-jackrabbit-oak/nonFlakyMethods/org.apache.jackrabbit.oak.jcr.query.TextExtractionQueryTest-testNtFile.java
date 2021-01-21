public void testNtFile() throws RepositoryException, IOException {
  while (testRootNode.hasNode(nodeName1)) {
    testRootNode.getNode(nodeName1).remove();
  }
  String content="The quick brown fox jumps over the lazy dog.";
  Node file=JcrUtils.putFile(testRootNode,nodeName1,"text/plain",new ByteArrayInputStream(content.getBytes("UTF-8")));
  testRootNode.getSession().save();
  String xpath=testPath + "/*[jcr:contains(jcr:content, 'lazy')]";
  executeXPathQuery(xpath,new Node[]{file});
}
