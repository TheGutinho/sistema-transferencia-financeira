import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Transferencia, TransferenciaService } from './transferencia.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App implements OnInit {
  transferencia: Transferencia = {
    contaOrigem: '',
    contaDestino: '',
    valor: 0,
    dataTransferencia: ''
  };

  transferencias: Transferencia[] = [];
  errorMessage: string = '';
  successMessage: string = '';

  constructor(private transferenciaService: TransferenciaService) {}

  ngOnInit(): void {
    this.carregarExtrato();
  }

  carregarExtrato() {
    this.transferenciaService.listar().subscribe({
      next: (dados: Transferencia[]) => this.transferencias = dados,
      error: (err: any) => console.error('Erro ao carregar extrato', err)
    });
  }

  onSubmit() {
    this.errorMessage = '';
    this.successMessage = '';

    this.transferenciaService.agendar(this.transferencia).subscribe({
      next: (res: any) => {
        this.successMessage = 'Transferência agendada com sucesso!';
        this.carregarExtrato();
        this.limparFormulario();
      },
      error: (err: any) => {
        this.errorMessage = err.error || 'Erro ao realizar agendamento. Verifique se a taxa é aplicável.';
      }
    });
  }

  limparFormulario() {
    this.transferencia = {
      contaOrigem: '',
      contaDestino: '',
      valor: 0,
      dataTransferencia: ''
    };
  }
}