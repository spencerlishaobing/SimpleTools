package com.simpletools.tvbridge;

/**
 * Android 平台的 Conscrypt 提供 "AES/CBC/PKCS7Padding" 等转换名，标准 OpenJDK 只认 PKCS5Padding
 * （两者在 AES 下行为完全一致）。该 Provider 注册同名转换，内部全部委托给标准 JCE 的 PKCS5 实现，
 * 使使用 PKCS7Padding 命名的外置片源可在桌面 JVM 正常运行。
 */
public class Pkcs7Provider extends java.security.Provider {
    public Pkcs7Provider() {
        super("Pkcs7Compat", 1.0, "PKCS7Padding alias for the standard PKCS5Padding implementation");
        put("Cipher.AES/CBC/PKCS7Padding", Pkcs7Cipher.class.getName());
        put("Cipher.AES/ECB/PKCS7Padding", Pkcs7Cipher.class.getName());
        put("Cipher.AES/CTR/PKCS7Padding", Pkcs7Cipher.class.getName());
        put("Cipher.AES/GCM/PKCS7Padding", Pkcs7Cipher.class.getName());
    }

    public static class Pkcs7Cipher extends javax.crypto.CipherSpi {
        private javax.crypto.Cipher delegate;
        private String mode = "CBC";

        private javax.crypto.Cipher cipher() throws Exception {
            if (delegate == null) {
                delegate = javax.crypto.Cipher.getInstance("AES/" + mode + "/PKCS5Padding");
            }
            return delegate;
        }

        protected void engineSetMode(String value) {
            if (value != null) mode = value.toUpperCase(java.util.Locale.ROOT);
        }

        protected void engineSetPadding(String value) throws javax.crypto.NoSuchPaddingException {
            // PKCS7Padding 与 PKCS5Padding 在 AES 下一致，统一由委托实例的 PKCS5Padding 处理
        }

        protected int engineGetBlockSize() {
            try { return cipher().getBlockSize(); } catch (Exception e) { return 16; }
        }

        protected int engineGetOutputSize(int inputLen) {
            try { return cipher().getOutputSize(inputLen); } catch (Exception e) { return inputLen + 16; }
        }

        protected byte[] engineGetIV() {
            try { return cipher().getIV(); } catch (Exception e) { return null; }
        }

        protected java.security.AlgorithmParameters engineGetParameters() {
            try { return cipher().getParameters(); } catch (Exception e) { return null; }
        }

        protected void engineInit(int opmode, java.security.Key key, java.security.SecureRandom random)
                throws java.security.InvalidKeyException {
            try { cipher().init(opmode, key, random); }
            catch (java.security.InvalidKeyException e) { throw e; }
            catch (Exception e) { throw new java.security.InvalidKeyException(e.toString()); }
        }

        protected void engineInit(int opmode, java.security.Key key, java.security.spec.AlgorithmParameterSpec params,
                java.security.SecureRandom random) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
            try { cipher().init(opmode, key, params, random); }
            catch (java.security.InvalidKeyException | java.security.InvalidAlgorithmParameterException e) { throw e; }
            catch (Exception e) { throw new java.security.InvalidAlgorithmParameterException(e.toString()); }
        }

        protected void engineInit(int opmode, java.security.Key key, java.security.AlgorithmParameters params,
                java.security.SecureRandom random) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
            try { cipher().init(opmode, key, params, random); }
            catch (java.security.InvalidKeyException | java.security.InvalidAlgorithmParameterException e) { throw e; }
            catch (Exception e) { throw new java.security.InvalidAlgorithmParameterException(e.toString()); }
        }

        protected byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
            try { return cipher().update(input, inputOffset, inputLen); }
            catch (Exception e) { throw new RuntimeException(e); }
        }

        protected int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset)
                throws javax.crypto.ShortBufferException {
            try { return cipher().update(input, inputOffset, inputLen, output, outputOffset); }
            catch (javax.crypto.ShortBufferException e) { throw e; }
            catch (Exception e) { throw new RuntimeException(e); }
        }

        protected byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen)
                throws javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
            try { return cipher().doFinal(input, inputOffset, inputLen); }
            catch (javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingException e) { throw e; }
            catch (Exception e) { throw new RuntimeException(e); }
        }

        protected int engineDoFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset)
                throws javax.crypto.ShortBufferException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
            try { return cipher().doFinal(input, inputOffset, inputLen, output, outputOffset); }
            catch (javax.crypto.ShortBufferException | javax.crypto.IllegalBlockSizeException | javax.crypto.BadPaddingException e) { throw e; }
            catch (Exception e) { throw new RuntimeException(e); }
        }
    }
}
