import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        int arraysize = this.size();
        if (arraysize < 10000) {
            storage[arraysize] = r;
        } else System.out.println("Array size exceeded");
    }

    Resume get(String uuid) {
        int arraysize = 0;
        while (storage[arraysize] != null) {
            if (storage[arraysize].uuid.equals(uuid)) {
                return storage[arraysize];
            }
            arraysize++;
        }
        System.out.println("Object with entered uuid not found");
        return null;
    }

    void delete(String uuid) {
        Resume recordtodelete = this.get(uuid);
        int arraysize = this.size();
        Integer recordposition = null;
        for (int i = 0; i < arraysize; i++) {
            if (storage[i] == recordtodelete) {
                recordposition = i;
                break;
            }
        }
        if (!recordposition.equals(null)) {
            for (int i = recordposition; i < arraysize - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[arraysize - 1] = null;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] arraywithoutnulls = new Resume[this.size()];
        System.arraycopy(storage, 0, arraywithoutnulls, 0, this.size());

        return arraywithoutnulls;
    }

    int size() {
        int arraysize = 0;
        while (storage[arraysize] != null) {
            arraysize++;
        }
        return arraysize;
    }
}
