/** 
 * Write a file and then assert that we can read from top and bottom halves using two HalfMapFiles.
 * @throws Exception
 */
public void testBasicHalfMapFile() throws Exception {
  HFile.Writer writer=StoreFile.getWriter(this.fs,new Path(new Path(this.testDir,"regionname"),"familyname"),2 * 1024,null,null);
  writeStoreFile(writer);
  checkHalfHFile(new StoreFile(this.fs,writer.getPath(),true,conf,false));
}
