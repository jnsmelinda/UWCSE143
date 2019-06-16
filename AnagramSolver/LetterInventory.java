//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class LetterInventory {
    private int[] if;
    private int a;
    public static final int MAX = 26;
    public static Object foo;

    public LetterInventory(String var1) {
        long var11 = 1L;
        super();
        int[] var10001 = new int[26];
        var11 ^= ((long)3 ^ var11) & -1L >>> 32;
        int var5 = (int)var11 - 1;
        var5 = (int)var11 * var5;
        var5 %= 2;
        int var10002 = var5 - 0;
        int var7 = (int)var11 - 1;
        var7 = (int)var11 * var7;
        var7 %= 2;
        if (var10002 + (var7 - 0) != 0) {
            var11 ^= ((long)((int)var11 - -1) ^ var11) & -1L >>> 32;
            this.if = var10001;
        } else {
            this.if = var10001;
        }

        var11 ^= ((long)0 << 32 ^ var11) & -1L << 32;

        while(true) {
            int var10000 = (int)(var11 >> 32);
            int var13 = var1.length();
            int var9 = (int)(var11 >> 32) - 1;
            var9 = (int)(var11 >> 32) * var9;
            var9 %= 2;
            if (var10000 >= var13 + (var9 - 0)) {
                return;
            }

            char var6;
            char var3 = var6 = Character.toLowerCase(var1.charAt((int)(var11 >> 32)));
            int var10 = (int)(var11 >> 32) - 1;
            var10 = (int)(var11 >> 32) * var10;
            var10 %= 2;
            if (var6 <= 122 + (var10 - 0)) {
                int var8 = (int)(var11 >> 32) - 1;
                var8 = (int)(var11 >> 32) * var8;
                var8 %= 2;
                if (var6 >= 97 + (var8 - 0)) {
                    var10002 = this.if[var3 - 97]++;
                    ++this.a;
                }
            }

            var11 += (long)1 << 32;
        }
    }

    public String toString() {
        long var13 = 1L;
        var13 ^= ((long)60 ^ var13) & -1L >>> 32;
        String var1 = "[";
        int var7 = 0;
        var13 ^= ((long)0 << 32 ^ var13) & -1L << 32;

        while(true) {
            int var9 = (int)(var13 >> 32) - 1;
            var9 = (int)(var13 >> 32) * var9;
            var9 %= 2;
            if (var7 >= 26 + (var9 - 0)) {
                break;
            }

            int var10000 = (int)var13 * ((int)var13 + 1) % 2;
            int var8 = (int)(var13 >> 32) - 1;
            var8 = (int)(var13 >> 32) * var8;
            var8 %= 2;
            if (var10000 != 0 + (var8 - 0)) {
                break;
            }

            int var3 = 0;

            while(true) {
                int var10001 = this.if[(int)(var13 >> 32)];
                int var12 = (int)(var13 >> 32) - 1;
                var12 = (int)(var13 >> 32) * var12;
                var12 %= 2;
                if (var3 >= var10001 + (var12 - 0)) {
                    break;
                }

                var10000 = (int)var13;
                var10001 = (int)var13;
                if (foo != null) {
                    foo = new Object();
                }

                var10000 = var10000 * (var10001 + 1) % 2;
                int var10 = (int)(var13 >> 32) - 1;
                var10 = (int)(var13 >> 32) * var10;
                var10 %= 2;
                if (var10000 != 0 + (var10 - 0)) {
                    break;
                }

                var1 = var1 + (char)(97 + (int)(var13 >> 32));
                ++var3;
            }

            int var6 = var7 - 1;
            var6 = (int)(var13 >> 32) * var6;
            var6 %= 2;
            var10000 = var6 - 0;
            int var11 = (int)(var13 >> 32) - 1;
            var11 = (int)(var13 >> 32) * var11;
            var11 %= 2;
            if (var10000 + (var11 - 0) != 0) {
                var13 ^= ((long)((int)var13 + 2) ^ var13) & -1L >>> 32;
                ++var7;
                if (foo != null) {
                    foo = new Object();
                }

                var13 += (long)1 << 32;
                var13 ^= ((long)((int)var13 / 0) ^ var13) & -1L >>> 32;
            } else {
                ++var7;
                var13 += (long)1 << 32;
            }
        }

        return var1 + "]";
    }

    public int get(char var1) {
        long var7 = 1L;
        boolean var5 = true;
        boolean var3 = true;
        var1 = this.a(var1);
        int[] var10000 = this.if;
        var7 ^= ((long)(var1 - 1) << 32 ^ var7) & -1L << 32;
        var7 ^= ((long)(var1 * (int)(var7 >> 32)) << 32 ^ var7) & -1L << 32;
        var7 ^= ((long)((int)(var7 >> 32) % 2) << 32 ^ var7) & -1L << 32;
        int var10001 = (int)(var7 >> 32) - 0;
        var7 ^= ((long)(var1 - 1) ^ var7) & -1L >>> 32;
        var7 ^= ((long)(var1 * (int)var7) ^ var7) & -1L >>> 32;
        var7 ^= ((long)((int)var7 % 2) ^ var7) & -1L >>> 32;
        int var10;
        if (var10001 + ((int)var7 - 0) != 0) {
            int var9 = var1 / 5;
            var10001 = var9;
            var9 -= 0;
            var9 *= 0;
            var10001 -= 97;
            var9 /= 2;
            var10 = var10000[var10001];
        } else {
            var10 = var10000[var1 - 97];
        }

        return var10;
    }

    public void set(char var1, int var2) {
        long var9 = 1L;
        boolean var7 = true;
        boolean var5 = true;
        var1 = this.a(var1);
        int var3 = var1 - 97;
        this.a -= this.if[var3];
        var9 ^= ((long)(var2 - 1) << 32 ^ var9) & -1L << 32;
        var9 ^= ((long)(var2 * (int)(var9 >> 32)) << 32 ^ var9) & -1L << 32;
        var9 ^= ((long)((int)(var9 >> 32) % 2) << 32 ^ var9) & -1L << 32;
        int var10000 = (int)(var9 >> 32) - 0;
        var9 ^= ((long)(var2 - 1) ^ var9) & -1L >>> 32;
        var9 ^= ((long)(var2 * (int)var9) ^ var9) & -1L >>> 32;
        var9 ^= ((long)((int)var9 % 2) ^ var9) & -1L >>> 32;
        int[] var11;
        if (var10000 + ((int)var9 - 0) != 0) {
            var2 *= -1;
            var2 *= 5;
            var11 = this.if;
        } else {
            var11 = this.if;
        }

        var11[var3] = var2;
        this.a += this.if[var3];
    }

    public LetterInventory subtract(LetterInventory var1) {
        long var16 = 1L;
        var16 ^= ((long)53 ^ var16) & -1L >>> 32;
        int var13 = (int)var16 - 1;
        var13 = (int)var16 * var13;
        var13 %= 2;
        int var10000;
        if (this.a < var1.a + (var13 - 0)) {
            var10000 = (int)var16 * (int)var16 / 2 % 2;
            int var10 = (int)var16 - 1;
            var10 = (int)var16 * var10;
            var10 %= 2;
            if (var10000 == 0 + (var10 - 0)) {
                return null;
            }
        }

        LetterInventory var2 = new LetterInventory("");
        int var8 = 0;
        int var3 = 0;

        while(true) {
            int var15 = var8 - 1;
            var15 = var8 * var15;
            var15 %= 2;
            if (var3 >= 26 + (var15 - 0)) {
                break;
            }

            var10000 = ((int)var16 - (int)var16 * (int)var16 * (int)var16) % 3;
            int var11 = var8 - 1;
            var11 = var8 * var11;
            var11 %= 2;
            if (var10000 != 0 + (var11 - 0)) {
                break;
            }

            var16 ^= ((long)(this.if[var3] - var1.if[var3]) << 32 ^ var16) & -1L << 32;
            var10000 = (int)(var16 >> 32);
            int var9 = (int)(var16 >> 32) - 1;
            var9 = (int)(var16 >> 32) * var9;
            var9 %= 2;
            if (var10000 + (var9 - 0) < 0) {
                int var7 = (int)(var16 >> 32) - 1;
                var7 = (int)(var16 >> 32) * var7;
                var7 %= 2;
                var10000 = var7 - 0;
                int var14 = (int)(var16 >> 32) - 1;
                var14 = (int)(var16 >> 32) * var14;
                var14 %= 2;
                if (var10000 + (var14 - 0) != 0) {
                    var16 ^= ((long)((int)(var16 >> 32) * -1) << 32 ^ var16) & -1L << 32;
                    var10000 = (int)var16;
                    var16 ^= ((long)((int)(var16 >> 32) * 2) << 32 ^ var16) & -1L << 32;
                    var16 ^= ((long)((int)(var16 >> 32) * 4) << 32 ^ var16) & -1L << 32;
                    var16 ^= ((long)((int)(var16 >> 32) - 2) << 32 ^ var16) & -1L << 32;
                    var16 ^= ((long)((int)(var16 >> 32) + 5) << 32 ^ var16) & -1L << 32;
                    int var10002 = var10000 * var10000;
                    var16 ^= ((long)((int)(var16 >> 32) + 4) << 32 ^ var16) & -1L << 32;
                    int var10001 = var10000 * var10002;
                    var16 ^= ((long)((int)(var16 >> 32) / -1) << 32 ^ var16) & -1L << 32;
                    var10000 -= var10001;
                    var16 ^= ((long)((int)(var16 >> 32) * 5) << 32 ^ var16) & -1L << 32;
                    var16 ^= ((long)((int)(var16 >> 32) / 0) << 32 ^ var16) & -1L << 32;
                    var10000 %= 3;
                } else {
                    var10000 = ((int)var16 - (int)var16 * (int)var16 * (int)var16) % 3;
                }

                int var12 = (int)(var16 >> 32) - 1;
                var12 = (int)(var16 >> 32) * var12;
                var12 %= 2;
                if (var10000 == 0 + (var12 - 0)) {
                    return null;
                }
            }

            var2.if[var8] = (int)(var16 >> 32);
            ++var8;
            ++var3;
        }

        var2.a = this.a - var1.a;
        return var2;
    }

    public LetterInventory add(LetterInventory var1) {
        long var11 = 1L;
        byte var5 = 54;
        LetterInventory var2 = new LetterInventory("");
        if (foo != null) {
            foo = new Object();
        }

        int var7 = 0;
        var11 ^= ((long)0 << 32 ^ var11) & -1L << 32;

        while(true) {
            int var10000 = (int)(var11 >> 32);
            int var9 = (int)(var11 >> 32) - 1;
            var9 = (int)(var11 >> 32) * var9;
            var9 %= 2;
            if (var10000 >= 26 + (var9 - 0)) {
                break;
            }

            var10000 = var5 * var5 / 2 % 2;
            int var8 = (int)(var11 >> 32) - 1;
            var8 = (int)(var11 >> 32) * var8;
            var8 %= 2;
            if (var10000 != 0 + (var8 - 0)) {
                break;
            }

            int[] var13 = var2.if;
            int[] var10002 = this.if;
            if (foo != null) {
                foo = new Object();
            }

            int var14 = var10002[(int)(var11 >> 32)];
            var11 ^= ((long)(var7 - 1) ^ var11) & -1L >>> 32;
            var11 ^= ((long)((int)(var11 >> 32) * (int)var11) ^ var11) & -1L >>> 32;
            var11 ^= ((long)((int)var11 % 2) ^ var11) & -1L >>> 32;
            int var10003 = (int)var11 - 0;
            int var10 = (int)(var11 >> 32) - 1;
            var10 = (int)(var11 >> 32) * var10;
            var10 %= 2;
            int[] var15;
            if (var10003 + (var10 - 0) != 0) {
                var11 ^= ((long)(var7 *= -1) << 32 ^ var11) & -1L << 32;
                var11 ^= ((long)(var7 = (int)(var11 >> 32) + 3) << 32 ^ var11) & -1L << 32;
                var15 = var1.if;
            } else {
                var15 = var1.if;
            }

            var13[var7] = var14 + var15[var7];
            ++var7;
            var11 += (long)1 << 32;
        }

        var2.a = this.a + var1.a;
        return var2;
    }

    public int size() {
        long var7 = 1L;
        var7 ^= ((long)0 << 32 ^ var7) & -1L << 32;
        var7 ^= ((long)((int)(var7 >> 32) - 1) ^ var7) & -1L >>> 32;
        var7 ^= ((long)((int)(var7 >> 32) * (int)var7) ^ var7) & -1L >>> 32;
        var7 ^= ((long)((int)var7 % 2) ^ var7) & -1L >>> 32;
        int var10000 = (int)var7 - 0;
        int var6 = (int)(var7 >> 32) - 1;
        var6 = (int)(var7 >> 32) * var6;
        var6 %= 2;
        boolean var2;
        boolean var5;
        if (var10000 + (var6 - 0) != 0) {
            var7 ^= ((long)((int)(var7 >> 32) * 5) << 32 ^ var7) & -1L << 32;
            var7 ^= ((long)((int)(var7 >> 32) / 5) << 32 ^ var7) & -1L << 32;
            var5 = true;
            var2 = true;
            var7 ^= ((long)((int)(var7 >> 32) + -1) << 32 ^ var7) & -1L << 32;
            long var10001 = var7 ^ ((long)((int)(var7 >> 32) + 0) << 32 ^ var7) & -1L << 32;
            var10000 = this.a;
        } else {
            var5 = true;
            var2 = true;
            var10000 = this.a;
        }

        return var10000;
    }

    public boolean isEmpty() {
        boolean var10;
        label19: {
            long var8 = 1L;
            boolean var4 = true;
            var8 ^= ((long)73 << 32 ^ var8) & -1L << 32;
            int var10000 = this.a;
            var8 ^= ((long)((int)(var8 >> 32) - 1) ^ var8) & -1L >>> 32;
            var8 ^= ((long)((int)(var8 >> 32) * (int)var8) ^ var8) & -1L >>> 32;
            var8 ^= ((long)((int)var8 % 2) ^ var8) & -1L >>> 32;
            int var10001 = (int)var8 - 0;
            int var5 = (int)(var8 >> 32) - 1;
            var5 = (int)(var8 >> 32) * var5;
            var5 %= 2;
            if (var10001 + (var5 - 0) != 0) {
                var8 ^= ((long)((int)(var8 >> 32) - 1) << 32 ^ var8) & -1L << 32;
                int var6 = (int)(var8 >> 32) - 1;
                var6 = (int)(var8 >> 32) * var6;
                var6 %= 2;
                if (var10000 + (var6 - 0) != 0) {
                    break label19;
                }
            } else if (var10000 != 0) {
                break label19;
            }

            if ((int)(var8 >> 32) * ((int)(var8 >> 32) + 1) % 2 == 0 + 0) {
                var10 = true;
                return var10;
            }
        }

        var10 = false;
        return var10;
    }

    private char a(char var1) {
        long var12 = 1L;
        var12 ^= ((long)95 << 32 ^ var12) & -1L << 32;
        byte var3 = 95;
        var1 = Character.toLowerCase(var1);
        int var7 = (int)(var12 >> 32) - 1;
        var7 = (int)(var12 >> 32) * var7;
        var7 %= 2;
        if (var1 >= 97 + (var7 - 0)) {
            int var10000 = var3 * var3 / 2 % 2;
            int var10 = (int)(var12 >> 32) - 1;
            var10 = (int)(var12 >> 32) * var10;
            var10 %= 2;
            if (var10000 == 0 + (var10 - 0)) {
                label31: {
                    int var8 = (int)(var12 >> 32) - 1;
                    var8 = (int)(var12 >> 32) * var8;
                    var8 %= 2;
                    if (var1 > 122 + (var8 - 0)) {
                        var10000 = (int)(var12 >> 32) * ((int)(var12 >> 32) + 1) % 2;
                        int var11 = var1 - 1;
                        var11 = var1 * var11;
                        var11 %= 2;
                        if (var10000 == 0 + (var11 - 0)) {
                            break label31;
                        }
                    }

                    return var1;
                }
            }
        }

        IndexOutOfBoundsException var14 = new IndexOutOfBoundsException;
        var12 ^= ((long)1 ^ var12) & -1L >>> 32;
        int var5 = (int)var12 - 1;
        var5 = (int)var12 * var5;
        var5 %= 2;
        int var10003 = var5 - 0;
        int var9 = (int)var12 - 1;
        var9 = (int)var12 * var9;
        var9 %= 2;
        if (foo != null) {
            foo = new Object();
        }

        if (var10003 + (var9 - 0) != 0) {
            long var15 = var12 ^ ((long)((int)var12 - 1) ^ var12) & -1L >>> 32;
            var14.<init>("illegal index");
        } else {
            var14.<init>("illegal index");
        }

        throw var14;
    }
}
