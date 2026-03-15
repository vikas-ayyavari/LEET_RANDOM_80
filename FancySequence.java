// 1622. Fancy Sequence
class Fancy {
    private static final long MOD = 1_000_000_007;
    private List<Long> seq;
    private long add;
    private long mult;

    public Fancy() {
        seq = new ArrayList<>();
        add = 0;
        mult = 1;
    }

    public void append(int val) {
        // Normalize and store
        long normalized = (val - add + MOD) % MOD;
        normalized = normalized * modPow(mult, MOD - 2) % MOD;
        seq.add(normalized);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        add = (add * m) % MOD;
        mult = (mult * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;
        long result = (seq.get(idx) * mult % MOD + add) % MOD;
        return (int) result;
    }

    // Fast modular exponentiation for modular inverse
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
