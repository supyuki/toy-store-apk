import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ToyAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ToyAdapter adapter = new ToyAdapter(getToyList(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Toy> getToyList() {
        // Implement logic to fetch toy data from a database or server
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("Toy 1", "Description 1", R.drawable.toy1));
        toys.add(new Toy("Toy 2", "Description 2", R.drawable.toy2));
        toys.add(new Toy("Toy 3", "Description 3", R.drawable.toy3));
        return toys;
    }

    @Override
    public void onItemClick(Toy toy) {
        // Handle click on a toy item
        Toast.makeText(this, "Clicked on " + toy.getName(), Toast.LENGTH_SHORT).show();
        // Implement navigation to detail activity or other actions
    }
}
