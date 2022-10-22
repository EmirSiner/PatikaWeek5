package com.example.patikaweek5.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.patikaweek5.databinding.FragmentFavoriteBinding
import com.example.patikaweek5.ui.favorite.viewmodel.FavoritesViewModel
import com.example.patikaweek5.ui.loadingprocess.LoadingProgressBar
import com.example.patikaweek5.ui.model.post.PostDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(), OnFavoriteClickListener {
    lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel by viewModels<FavoritesViewModel>()
    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingProgressBar = LoadingProgressBar(requireContext())

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.postLiveData.observe(viewLifecycleOwner) {

            binding.rvFavoritesList.adapter = FavoritesAdapter(this).apply {
                submitList(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getPosts()
    }

    override fun onFavoriteClick(post: PostDTO) {
        viewModel.onFavoritePost(post)
    }


}
