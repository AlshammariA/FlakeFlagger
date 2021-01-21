@Test public void customMetadata() throws Exception {
  System.setProperty("grape.root","target");
  File testArtifactDir=new File("target/repository/test/test/1.0.0");
  testArtifactDir.mkdirs();
  File testArtifact=new File(testArtifactDir,"test-1.0.0.properties");
  testArtifact.createNewFile();
  PrintWriter writer=new PrintWriter(new FileWriter(testArtifact));
  writer.println("javax.ejb\\:ejb-api=3.0");
  writer.close();
  this.cli.grab("customGrabMetadata.groovy","--autoconfigure=false");
  assertTrue(new File("target/repository/javax/ejb/ejb-api/3.0").isDirectory());
}
