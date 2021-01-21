/** 
 * Test that our mechanism of writing store files in one region to reference store files in other regions works.
 * @throws IOException
 */
public void testReference() throws IOException {
  Path storedir=new Path(new Path(this.testDir,"regionname"),"familyname");
  Path dir=new Path(storedir,"1234567890");
  HFile.Writer writer=StoreFile.getWriter(this.fs,dir,8 * 1024,null,null);
  writeStoreFile(writer);
  StoreFile hsf=new StoreFile(this.fs,writer.getPath(),true,conf,false);
  HFile.Reader reader=hsf.getReader();
  KeyValue kv=KeyValue.createKeyValueFromKey(reader.midkey());
  byte[] midRow=kv.getRow();
  kv=KeyValue.createKeyValueFromKey(reader.getLastKey());
  byte[] finalRow=kv.getRow();
  Path refPath=StoreFile.split(fs,dir,hsf,midRow,Range.top);
  StoreFile refHsf=new StoreFile(this.fs,refPath,true,conf,false);
  HFileScanner s=refHsf.getReader().getScanner(false,false);
  for (boolean first=true; (!s.isSeeked() && s.seekTo()) || s.next(); ) {
    ByteBuffer bb=s.getKey();
    kv=KeyValue.createKeyValueFromKey(bb);
    if (first) {
      assertTrue(Bytes.equals(kv.getRow(),midRow));
      first=false;
    }
  }
  assertTrue(Bytes.equals(kv.getRow(),finalRow));
}
