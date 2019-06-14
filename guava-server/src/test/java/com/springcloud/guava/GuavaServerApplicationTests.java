package com.springcloud.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.*;
import com.springcloud.guava.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuavaServerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void guvavHash() {
        HashFunction hf = Hashing.md5();

        HashCode hc = hf.newHasher()
                .putBoolean(true)
                .putString("rocky", Charsets.UTF_8)
                .hash();
        System.out.println(hc);
        System.out.println(hc.toString().length());

        HashFunction hashFunction = Hashing.murmur3_128();
        hashFunction.newHasher()
                .putBoolean(true)
                .putString("rocky", Charsets.UTF_8)
                .hash();
        System.out.println(hashFunction);
    }

    @Test
    public void guvavHashFunnel() {
        Account account = new Account("1001", "admin", "11223344");
        Funnel<Account> accountFunnel = new Funnel<Account>() {
            @Override
            public void funnel(Account from, PrimitiveSink into) {
                into.putInt(1001)
                        .putString(account.getUsername(), Charsets.UTF_8)
                        .putString(account.getPassword(), Charsets.UTF_8);

            }
        };
        int i = accountFunnel.hashCode();
        System.out.println(i);
        HashCode hashCode = HashCode.fromString("1001");
    }

    @Test
    public void bloomFilter() {

        int total = 1000000;

        Funnel<CharSequence> charSequenceFunnel = Funnels.stringFunnel(Charsets.UTF_8);
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(charSequenceFunnel, total, 0.03);

        for (int i = 0; i < total; i++) {
            bloomFilter.put(Integer.toString(i));
        }

        int count = 0;
        for (int j = 0; j < total + 10000; j++) {
            if (bloomFilter.mightContain(Integer.toString(j))) {
                count++;
            }
        }
        System.out.println(count);//1000309
        // (total + 10000) * 0.03/100
    }


}
