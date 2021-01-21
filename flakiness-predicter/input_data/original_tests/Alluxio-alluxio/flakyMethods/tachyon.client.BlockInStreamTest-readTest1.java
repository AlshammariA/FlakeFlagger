/** 
 * Test <code>void read()</code>.
 */
@Test public void readTest1() throws IOException {
  for (int k=MIN_LEN; k <= MAX_LEN; k+=DELTA) {
    for (    WriteType op : WriteType.values()) {
      int fileId=TestUtils.createByteFile(mTfs,"/root/testFile_" + k + "_"+ op,op,k);
      TachyonFile file=mTfs.getFile(fileId);
      InStream is=(k < MEAN ? file.getInStream(ReadType.CACHE) : file.getInStream(ReadType.NO_CACHE));
      if (k == 0) {
        Assert.assertTrue(is instanceof EmptyBlockInStream);
      }
 else {
        Assert.assertTrue(is instanceof BlockInStream);
      }
      byte[] ret=new byte[k];
      int value=is.read();
      int cnt=0;
      while (value != -1) {
        ret[cnt++]=(byte)value;
        value=is.read();
      }
      Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
      is.close();
      is=(k < MEAN ? file.getInStream(ReadType.CACHE) : file.getInStream(ReadType.NO_CACHE));
      if (k == 0) {
        Assert.assertTrue(is instanceof EmptyBlockInStream);
      }
 else {
        Assert.assertTrue(is instanceof BlockInStream);
      }
      ret=new byte[k];
      value=is.read();
      cnt=0;
      while (value != -1) {
        ret[cnt++]=(byte)value;
        value=is.read();
      }
      Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
      is.close();
    }
  }
}